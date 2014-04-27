package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * 
 * Provides the default functionality and 2 operations for subclasses to provide implementations for: 
 * <br>
 * (1) deciding if they want to review the document.
 * <br>
 * (2) method to call to review the document.
 * <p>
 * Consumers of the pattern call the reviewDocument() method.
 * 
 * @author gazbert
 *
 */
public abstract class AbstractDocumentReviewHandler implements DocumentReviewHandler {

    /** Here for our test assertions to track who's reviewed the document */
    private static String handledBy = "";

    /**
     * Holds reference to the next Handler/Receiver.
     */
    private DocumentReviewHandler nextHandler;  

    /**
     * Consumers of the pattern call this method to do stuff.
     * <p>
     * This is the business method.
     * <p>
     * In this case, JIRA/Bugzilla would call this with the document to review...
     * 
     * @param document
     */
    public static void reviewDocumentRequest(final String document)
    {
        // Create the handlers/receivers
        final DocumentReviewHandler supportReviewHandler = new SupportReviewHandler();
        final DocumentReviewHandler salesReviewHandler = new SalesReviewHandler();
        final DocumentReviewHandler engineeringReviewHandler = new EngineeringReviewHandler();
        final DocumentReviewHandler testingReviewHandler = new TestingReviewHandler();

        // Chain em together - totally random order of chaining here ;-)
        supportReviewHandler.setNextHandler(salesReviewHandler);
        salesReviewHandler.setNextHandler(engineeringReviewHandler);
        engineeringReviewHandler.setNextHandler(testingReviewHandler);	
        testingReviewHandler.setNextHandler(null); // see NullObjectPattern for better way of 'ending' stuff

        // New review request comes in and gets routed to support team first... 
        supportReviewHandler.processHandler(document);
    }

    @Override
    public void setNextHandler(final DocumentReviewHandler handler) {
        this.nextHandler = handler;	
    }


    /*
     * The decision to process the review has been pushed up into the base class; we don't want each subclass
     * duplicating the same thing. 
     */
    @Override
    public void processHandler(String document) {

        boolean wordFound = false;

        // check for matching words for this Handler
        for (String word : getSelectionCriteria())
        {
            if (document.indexOf(word) >= 0)
            {
                wordFound = true;
                break;
            }
        }	    

        // Do the handling if we need to...
        if (wordFound)
        {
            handledBy = reviewDocument(document);
        }
        else
        {
            // Check if next Receiver 'wants it'... ;-o
            if (null != nextHandler)
            {
                nextHandler.processHandler(document);
            }
        }
    }

    /**
     * Only here for unit test code to assert stuff with sake of this demo.
     * @return
     */
    public static String getHandledBy()
    {
        return handledBy;	
    }

    ///////////////////// Subclass contract for the concrete Handlers ////////////////////////

    /**
     * This is where we ask each Handler for its document review selection criteria.
     * @return
     */
    protected abstract String[] getSelectionCriteria();

    /**
     * This is where we send the document to interested Handlers.
     * @param document
     * @return department that reviewed the document
     */       
    protected abstract String reviewDocument(String document);
}
