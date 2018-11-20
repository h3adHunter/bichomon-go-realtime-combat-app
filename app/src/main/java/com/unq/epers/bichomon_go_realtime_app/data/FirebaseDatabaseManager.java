package com.unq.epers.bichomon_go_realtime_app.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.unq.epers.bichomon_go_realtime_app.CombatListActivity;
import com.unq.epers.bichomon_go_realtime_app.model.Combate;

public class FirebaseDatabaseManager {

    private static final String KEY_COMBATES = "combates";

    private static DatabaseReference databaseReference;
    private static FirebaseDatabaseManager instance;

    private FirebaseDatabaseManager() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        instance = this;


    }

    public static FirebaseDatabaseManager getInstance(){
        if (instance == null) {
            instance = new FirebaseDatabaseManager();
        }
        return instance;
    }

    public void agregarCombate(Combate combate){
        String id = combate.getFecha().toString();

        databaseReference
                .child(KEY_COMBATES)
                .child(id)
                .setValue(combate);
    }

    public void setCombatesChildEventListener(final CombatListActivity combatListActivity) {
        ChildEventListener combatesEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Combate combate = dataSnapshot.getValue(Combate.class);
                combatListActivity.agregarCombate(combate);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Combate combate = dataSnapshot.getValue(Combate.class);
//                combatListActivity.editarCombate(combate);
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Combate combate = dataSnapshot.getValue(Combate.class);
//                combatListActivity.eliminarCombate(combate);
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        };

        databaseReference
                .child(KEY_COMBATES)
                .addChildEventListener(combatesEventListener);
    }
}
