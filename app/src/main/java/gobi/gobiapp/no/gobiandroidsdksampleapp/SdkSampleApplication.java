package gobi.gobiapp.no.gobiandroidsdksampleapp;

import android.app.Application;

import no.gobiapp.gobi.sdk.Gobi;

/**
 * The Application instance is a singleton registered in {@code AndroidManifest.xml}.
 * Initialize Gobi in {@link #onCreate()}.
 *
 * @author Kristian 'krissrex' Rekstad
 */
public class SdkSampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final String gobiCustomerId = "ZDY5OGI0YZQ3MJG0MWE3ZDA0YWEXZDLK"; // "Sample SDK app" customer
        Gobi.with(this, gobiCustomerId);
    }
}
