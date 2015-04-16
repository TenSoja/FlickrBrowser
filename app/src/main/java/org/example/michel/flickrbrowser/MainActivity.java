package org.example.michel.flickrbrowser;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = "MainActivity";
    private List<Photo> mPhotoList = new ArrayList<Photo>();
    private RecyclerView mRecyclerView;
    private FlickrRecyblerViewAdapter flickrRecyblerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }

//        GetRawData theRawData = new GetRawData("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,lollipop&format=json&nojsoncallback=1");
        GetFlickrJsonData jsonData = new GetFlickrJsonData("android, lollipop", true);
        jsonData.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   public class ProcessPhotos extends GetFlickrJsonData {

       public ProcessPhotos(String searchCriteria, boolean matchAll) {
           super(searchCriteria, matchAll);
       }

       public void execute() {
           super.execute();
           ProcessData processData = new ProcessData();
           processData.execute();

       }

       public class ProcessData extends DownloadJsonData {

           protected void onPostExecute(String webData) {
               super.onPostExecute(webData);
               flickrRecyblerViewAdapter = new FlickrRecyblerViewAdapter(MainActivity.this. getMPhotos());
               mRecyclerView.setAdapter(flickrRecyblerViewAdapter);
           }

       }
   }


}
