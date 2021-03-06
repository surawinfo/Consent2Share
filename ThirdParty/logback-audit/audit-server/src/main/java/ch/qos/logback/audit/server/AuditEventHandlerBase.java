/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 2006-2011, QOS.ch. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */

package ch.qos.logback.audit.server;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.audit.AuditEvent;
import ch.qos.logback.audit.AuditException;


abstract class AuditEventHandlerBase implements AuditEventHandler {

  List<AuditListener> auditListenerList = new ArrayList<AuditListener>();
  
  public void addAuditListener(AuditListener auditListener) {
    auditListenerList.add(auditListener);
  }

  abstract public void doHandle(AuditEvent ae) throws AuditException;

  protected void fireIncoming(AuditEvent ae) {
    for(AuditListener listener: auditListenerList) {
      listener.incoming(ae);
    }
  }
  public boolean removeAuditListener(AuditListener auditListener) {
    return auditListenerList.remove(auditListener);
  }

}
