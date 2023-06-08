package com.example.disasterprepfrontend;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationClass extends Application {

    ExecutorService srv = Executors.newCachedThreadPool();
    ArrayList<ModelChecklist> checklistsList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();

    public ExecutorService getSrv() {
        return srv;
    }

    public ArrayList<ModelChecklist> getChecklistsList() {
        return checklistsList;
    }
}
