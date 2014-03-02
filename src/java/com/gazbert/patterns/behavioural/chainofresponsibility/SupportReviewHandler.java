package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Handler for support team.
 * 
 * @author gazbert
 *
 */
public class SupportReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {
	
	return new String[] { "support", "customer", "installation" };
    }

    @Override
    protected String reviewDocument(final String document) {

	System.out.println("[" + document + "] This is a document for Support to review.");	
	return "support";
    }
}
