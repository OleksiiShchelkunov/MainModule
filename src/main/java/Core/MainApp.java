package Core;

import APItest.APIUtils;
import UItest.UIUtils;

public class MainApp {

    public static void main(String[] args) {
        String link = APIUtils.sendGetRequest("https://www.google.com/");
        UIUtils.openPage(link);
    }

}
