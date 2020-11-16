package com;

import org.json.simple.JSONObject;
import org.w3c.dom.Node;

public interface InfoIterator {

    boolean isDone();

    void goNext();

    String currentString();

    Node currentNode();

    JSONObject currentObject();

}
