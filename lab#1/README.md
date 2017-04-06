# Event driven Programming Lab1

I decided to make this laboratory work in Android Studio.
- For adding a text in middle of screen I created a text view using <TextView>.

    ```
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Done with Pride and Prejudice by Dragoș Străinu"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"
        android:id="@+id/mainText" />
    ```
  I arranged it on center and set the text propriety.

- Also I added 2 buttons and another 2 TextViews

  ```
  <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Default Button"
    android:id="@+id/defaultButton"
    android:layout_alignParentTop="true"
    android:layout_alignParentStart="true"
    android:layout_marginTop="30dp" />

  <Button
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Custom Button"
      android:id="@+id/customButton"
      android:layout_alignTop="@+id/defaultButton"
      android:layout_alignParentStart="true"
      android:layout_marginTop="60dp"
      android:theme="@style/customButton" />

  <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Default Text"
      android:id="@+id/defaultText" />

  <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:text="Custom Text"
      android:layout_marginTop="150dp"
      android:layout_marginLeft="100dp"
      android:id="@+id/customText"
      android:theme="@style/customText"/>
  ```

  For customButton and customText I added 2 styles in style.xml

  ```
  <style name="customButton" parent="Theme.AppCompat.Light">
      <item name="colorButtonNormal">#020e39</item>
      <item name="android:textColor">#FFFFFF</item>
      <item name="android:fontFamily">sans-serif-condensed</item>
      <item name="android:textStyle">bold|italic</item>
  </style>

  <style name="customText" parent="Theme.AppCompat.Light">
      <item name="android:background">#00FF99</item>
      <item name="android:textColor">#FF0000</item>
      <item name="android:fontFamily">sans-serif-thin</item>
      <item name="android:textStyle">italic</item>
      <item name="android:textSize">40dp</item>
  </style>
  ```

App locks like this:

  ![Alt](images/1.png =300x)

- For interaction between elements I added onClick Event for customButton. On click it will change customText size.

  ```
  Button customButton = (Button) findViewById(R.id.customButton);
          final TextView customText = (TextView) findViewById(R.id.customText);


          customButton.setOnClickListener( new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  customText.setTextSize(15);
              }
          });
  ```

After click:

  ![Alt](images/2.png =300x)
