package com.example.app.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.Journal;
import com.example.app.model.ResponseData;
import com.example.app.model.ResponseObjectData;
import com.example.app.network.GetJournalData;
import com.example.app.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        private RecyclerView mRecyclerView;
        private ArrayList<Journal> mArrayListJournalData;
        private JournalAdapter mAdapter;
        private ProgressDialog progressDoalog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initViews();
            getJournalData();
        }

        private void initViews(){
            mRecyclerView = (RecyclerView)findViewById(R.id.journal_recycler_view);
            mRecyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(layoutManager);
        }

        private void getJournalData() {
           // showProgressBar();
          //  checkIfDataPresentInLocalDB();
            fetchJournalDataFromAPI();
        }


        //Fetch data from api
        private void fetchJournalDataFromAPI() {
            GetJournalData journalDataService = RetrofitClientInstance.getRetrofitInstance().create(GetJournalData.class);
            Call<ResponseData> call = journalDataService.getJournalData("title:DNA");
            call.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                //    progressDoalog.dismiss();
                    if(response.body()!=null) {
                        Log.d("TAG", "Data: " + response.body().getResponseObjectData());
                        ResponseObjectData responseObjectData = response.body().getResponseObjectData();
                       //mArrayListJournalData = (ArrayList<Journal>) responseObjectData.getJournalList();
                        setAdapterData(responseObjectData.getJournalList());

                       // SaveJournalData saveJournalData = new SaveJournalData();
                        //saveJournalData.execute();
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
                  //  progressDoalog.dismiss();
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }

    private void setAdapterData(List<Journal> journalList) {
        mAdapter = new JournalAdapter(journalList,MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void checkIfDataPresentInLocalDB() {
        /*GetJournalDataFromDatabase getJournalDataFromDatabase = new GetJournalDataFromDatabase();
        getJournalDataFromDatabase.execute();*/
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return super.onOptionsItemSelected(item);
        }

        private void showProgressBar() {
            progressDoalog = new ProgressDialog(getApplicationContext());
            progressDoalog.setMessage("Loading....");
            progressDoalog.show();
        }


   /* public class SaveJournalData extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            if(mArrayListJournalData!=null && mArrayListJournalData.size()>0) {
                DatabaseClient databaseClient = DatabaseClient.getInstance(getApplicationContext());
                JournalDatabase journalDatabase =  databaseClient.getJournalDatabase();
                for(int i=0;i<mArrayListJournalData.size();i++){
                    Journal journal = mArrayListJournalData.get(i);
                    journalDatabase.journalDao().insert(journal);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Journal Data Saved Successfully..", Toast.LENGTH_LONG).show();
        }
    }

    class GetJournalDataFromDatabase extends AsyncTask<Void, Void, List<JournalDB>> {

        @Override
        protected List<JournalDB> doInBackground(Void... voids) {
            List<JournalDB> taskList = DatabaseClient
                    .getInstance(getApplicationContext())
                    .getJournalDatabase()
                    .journalDao()
                    .getAll();
            return taskList;
        }

        @Override
        protected void onPostExecute(List<JournalDB> journalList) {
            super.onPostExecute(journalList);
            if(journalList!=null && journalList.size()>0) {
              //  progressDoalog.dismiss();
               // setAdapterData(journalList);
            }else {
                fetchJournalDataFromAPI();
            }
        }
    }*/
}

