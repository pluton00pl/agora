package com.company.agora.web.screens.agoraevent;

import com.haulmont.cuba.gui.screen.*;
import com.company.agora.entity.AgoraEvent;

@UiController("agora_AgoraEvent.browse")
@UiDescriptor("agora-event-browse.xml")
@LookupComponent("agoraEventsTable")
@LoadDataBeforeShow
public class AgoraEventBrowse extends StandardLookup<AgoraEvent> {
}