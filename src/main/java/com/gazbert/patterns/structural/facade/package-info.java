/**
 * <h2>Facade</h2>
 * Used to provide a more abstract and shared/unified interface to multiple lower-level interfaces/classes/subsystems; 
 * a facade provides a higher-level and simpler interface for Clients to use. A good facade presents to the client the
 * appropriate level of abstraction.
 * 
 * <h2>Actors</h2>
 * <ul>
 * <li>Facade - the simplified higher-level interface that Clients use; it calls down to the interfaces on the 
 *              subsystems.</li> 
 * <li>Client - uses the Facade.</li> 
 * </ul>
 * 
 * <h2>Usages</h2>
 * Use whenever you need to provide a more simple and abstract business method(s) to a Client. A Facade helps protect 
 * the Client from changes to subsystem interfaces; it is often used during the development cycle to protect other
 * developers from subsystem interface changes.
 * 
 * <p>
 * @author gazbert
 *
 */
package com.gazbert.patterns.structural.facade;