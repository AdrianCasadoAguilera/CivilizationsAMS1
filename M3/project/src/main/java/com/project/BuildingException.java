package com.project;

public class BuildingException extends Exception {
    public BuildingException(String task, String BuildingRequired) {
        super(task + ", You need" + BuildingRequired);
    }
}
