package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Handler for Engineering team.
 * 
 * @author gazbert
 *
 */
public class EngineeringReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {

        return new String[] { "engineering", "development", "developing" };
    }

    @Override
    protected String reviewDocument(String document) {

        System.out.println("[" + document + "] This is a document for Engineering to review.");	
        return "engineering";
    }
}
