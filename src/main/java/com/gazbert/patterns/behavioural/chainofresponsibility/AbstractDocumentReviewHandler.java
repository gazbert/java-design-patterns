/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Provides the default functionality and 2 operations for subclasses to provide implementations for:
 * <br>
 * (1) deciding if they want to review the document.
 * <br>
 * (2) method to call to review the document.
 * <p>
 * Consumers of the pattern call the reviewDocument() method.
 *
 * @author gazbert
 */
public abstract class AbstractDocumentReviewHandler implements DocumentReviewHandler {

    /**
     * Here for our test assertions to track who's reviewed the document
     */
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
     * @param document the doc to review
     */
    public static void reviewDocumentRequest(String document) {
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
    public void setNextHandler(DocumentReviewHandler handler) {
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
        for (String word : getSelectionCriteria()) {
            if (document.contains(word)) {
                wordFound = true;
                break;
            }
        }

        // Do the handling if we need to...
        if (wordFound) {
            handledBy = reviewDocument(document);
        } else {
            // Check if next Receiver 'wants it'... ;-o
            if (null != nextHandler) {
                nextHandler.processHandler(document);
            }
        }
    }

    /**
     * Only here for unit test code to assert stuff with sake of this demo.
     *
     * @return handledBy
     */
    public static String getHandledBy() {
        return handledBy;
    }

    ///////////////////// Subclass contract for the concrete Handlers ////////////////////////

    /**
     * This is where we ask each Handler for its document review selection criteria.
     *
     * @return selection criteria
     */
    protected abstract String[] getSelectionCriteria();

    /**
     * This is where we send the document to interested Handlers.
     *
     * @param document the doc
     * @return department that reviewed the document
     */
    protected abstract String reviewDocument(String document);
}
