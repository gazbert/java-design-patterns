package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Handler for Test team.
 * 
 * @author gazbert
 *
 */
public class TestingReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {

        return new String[] { "testing", "test plan", "test case" };
    }

    @Override
    protected String reviewDocument(String document) {

        System.out.println("[" + document + "] This is a document for Testing to review.");
        return "testing";
    }
}
