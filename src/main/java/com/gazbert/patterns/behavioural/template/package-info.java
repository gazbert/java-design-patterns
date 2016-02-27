/**
 * <h2>Template Method</h2>
 *
 * Defines the skeleton behaviour of an algorithm (the template) but delegates some tasks to subclasses to
 * implement using 'hooks'.
 * <p>
 * The template class is an abstract and contains a final skeleton/template method - this means it can control the
 * flow of the behaviour and call down to the subclasses to provide specific behaviour.  The template
 * pattern <em>must</em> be final in order to prevent subclasses from changing the overall behaviour.
 * <p>
 * It makes use of the 'Hollywood Principle' - don't call us, we'll call you. Some of the hooks can have default behaviour - in case the subclasses choose not to override them - but
 * there should always be at least 1 abstract hook to in a Template pattern.
 * <p>
 * One final thing, the hook methods should have protected access - only subclasses should be able to use them. They are
 * not meant for public consumption; only the main template method should be public.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Abstract Template - an abstract class that provides the template method and a number of (optional) hooks
 *                         that subclasses can/must implement.</li>
 * <li>Template Subclass - extends the Abstract Template class and overrides some of the superclass's hooks.</li>
 * <li>Client - calls the template method to do something.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Very popular in frameworks where control needs to be maintained for the overall algorithm, but flexibility is
 * required to allow subclasses to provide the details it needs to fulfil the behaviour.
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.behavioural.template;