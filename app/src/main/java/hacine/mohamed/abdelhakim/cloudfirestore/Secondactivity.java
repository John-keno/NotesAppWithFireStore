package hacine.mohamed.abdelhakim.cloudfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Secondactivity extends AppCompatActivity {
         NoteAdapter adapter;
    private static final String TAG = "Secondactivity";
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            FloatingActionButton fab ;
            CollectionReference notebookRef = db.collection("Notebook");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        fab = findViewById(R.id.addid);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = notebookRef.orderBy("priority", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Note> options = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)
                .build();
            adapter = new NoteAdapter(options);
            RecyclerView recyclerView = findViewById(R.id.recyclerview);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);




          new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.UP |ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());


            }
                  }).attachToRecyclerView(recyclerView);

//           adapter.setOnItemClickListener(new NoteAdapter.OnItemClickListener() {
//               @Override
//               public void onItemClick(DocumentSnapshot documentSnapshot, int position) {


//                   Note note = documentSnapshot.toObject(Note.class);
//                             note.setDocumentid(documentSnapshot.getId());

//                             String title = note.getTitle();
//                             String description = note.getDescription();
//                   int prio = note.getPriority();
//                   Log.d(TAG, "onItemClick: "+ description);
//                              Intent iiii = new Intent(Secondactivity.this , DetailsActivity.class);
//                   iiii.putExtra("t",title);
//                   iiii.putExtra("d",description);
//                   iiii.putExtra("p",prio);
//                   startActivity(iiii);

//               }
//           });
    }
    @Override
    protected void onStart() {
                super.onStart();
                adapter.startListening();
    }
    @Override
    protected void onStop() {
              super.onStop();
              adapter.stopListening();
    }

    public void gotonew(View view) {


            startActivity(new Intent(Secondactivity.this , NewNoteActivity.class));

    }
}
