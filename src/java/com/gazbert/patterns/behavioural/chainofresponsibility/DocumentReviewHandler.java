package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Provides operations that each concrete Handler impl must provide.
 * 
 * @author gazbert
 *
 */
public interface DocumentReviewHandler {

    /**
     * Sets the next handler. The abstract impl usually calls this instead of each concrete impl.
     * 
     * @param handler
     */
    void setNextHandler(DocumentReviewHandler handler);
           
    /**
     * Each handler provides its own impl to do something with the message.
     * @param document
     */
    void processHandler(String document);       
}
