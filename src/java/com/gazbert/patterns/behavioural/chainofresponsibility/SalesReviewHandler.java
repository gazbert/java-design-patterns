package com.gazbert.patterns.behavioural.chainofresponsibility;

/**
 * Handler for Sales team.
 * 
 * @author gazbert
 *
 */
public class SalesReviewHandler extends AbstractDocumentReviewHandler {

    @Override
    protected String[] getSelectionCriteria() {
	
	return new String[] { "sales", "sell", "statement of work" };
    }

    @Override
    protected String reviewDocument(String document) {

	System.out.println("[" + document + "] This is a document for Sales to review.");
	return "sales";
    }
}
