package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity  {
private Button dogButton, catButton, birdButton, rabbitButton;
private ImageView dogImage, catImage,birdImage, rabbitImage, animalImage;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         dogImage = (ImageView) findViewById(R.id.animal);
         catImage = (ImageView) findViewById(R.id.animal);
         birdImage = (ImageView) findViewById(R.id.animal);
         rabbitImage = (ImageView) findViewById(R.id.animal);
         animalImage =(ImageView) findViewById(R.id.animal);
         animalImage.setImageResource(0);

}
    public void onDogButtonClick(View view){
        dogImage.setImageResource(R.drawable.dog);
    }
    public void onCatButtonClick(View view){
        catImage.setImageResource(R.drawable.cat);
    }
    public void onBirdButtonClick(View view){
        birdImage.setImageResource(R.drawable.bird);
    }
    public void onRabbitButtonClick(View view){
        rabbitImage.setImageResource(R.drawable.rabbit);
    }
}