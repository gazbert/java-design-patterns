/**
 * <h2>Adapter</h2>
 * Makes incompatible classes/interfaces work with each other, by converting one interface into the format expected
 * by the Client.
 * <p>
 * Classes/interfaces that get adapted are called Adaptees - they typically 3rd party APIs or legacy code that cannot
 * be changed. In the case of APIs, these normally just supply the JAR and Javadoc.
 * <p>
 * The system you have control over may want to integrate these Adaptees into an existing framework.
 * <p>
 * The class/interface you are adapting to is called the Target.
 * <p>
 * The class that adapts between the Adaptee and the Target is called the Adapter. The Adapter extends from the 
 * Target and 'wraps' the Adaptee. The wrapping is done by passing the Adaptee into the constructor of the Adapter.
 * <p>
 * The Adapter needs to override Target operations if it needs to adapt/delegate to the Adaptee methods.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Target interface - the interface the Client uses and expects. This is what we adapt to. </li>
 * <li>Adaptee - the class/interface we adapt from.</li>
 * <li>Adapter - the class that does the adapting from the Adaptee to the Target.</li>
 * <li>Client - the user of the Target interface.</li>
 * </ul>
 * 
 * <h2>Usages</h2>
 * Integrating 3rd party API classes into an organisation's existing codebase, integrating with legacy code that 
 * cannot be modified, acting as an interim solution when migrating code from a legacy system to a new system.
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.structural.adapter;