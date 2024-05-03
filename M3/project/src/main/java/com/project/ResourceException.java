package com.project;

public class ResourceException extends Exception {
    public ResourceException(String ResourceName, int RequiredAmount, int AvailableAmount) {
        super("Not enough " + ResourceName + " to build. Required: " + RequiredAmount + " Available: " + AvailableAmount);
    }
}
