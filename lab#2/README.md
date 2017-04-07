# Event driven programming lab2

- Create a View application what will display a dialog box on some event (ex. on clicking some button)

  I used AlertDialog for this tusk.

  ```
  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
  fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          new AlertDialog.Builder(MainActivity.this)
                  .setTitle("Alert Dialog in Android, link below")
                  .setMessage("http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android")
                  .setCancelable(false)
                  .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          // Whatever...
                      }
                  }).show();
      }
  });
  ```

  ![Alt](images/lab%232-2.gif)

- Add a system menu to your application with at least 3 items (add actions to that items)

  I override a function onOptionsItemSelected and set for each click an action.

  ```
  @Override
      public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();
          View root = findViewById(R.id.content_layout).getRootView();
          switch (id) {
              case R.id.action_toast:
                  Toast.makeText(MainActivity.this, getString(R.string.action_toast), Toast.LENGTH_LONG).show();
                  break;
              case R.id.action_change_bg:
                  Random rnd = new Random();
                  int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                  root.setBackgroundColor(color);
                  break;
              case R.id.action_default_bg:
                  root.setBackgroundColor(Color.WHITE);
                  break;
          }
          return super.onOptionsItemSelected(item);
      }
  ```

  ![Alt](images/lab%232-1.gif)

- Hook keyboard input. Add 2 custom events.

  I hooked volume buttons.

  ```
  @Override
  public boolean onKeyDown(int keycode, KeyEvent e) {

      View root = findViewById(R.id.content_layout).getRootView();
      Random rnd = new Random();
      int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

      switch(keycode) {
          case KeyEvent.KEYCODE_VOLUME_UP:
              Toast.makeText(MainActivity.this, "Volume Up", Toast.LENGTH_SHORT).show();
              break;
          case KeyEvent.KEYCODE_VOLUME_DOWN:
              root.setBackgroundColor(color);
              break;
      }

      return super.onKeyDown(keycode, e);
  }
  ```

  ![Alt](images/lab%232-3.gif)
  ![Alt](images/lab%232-4.gif)

- Customize your application by adding an icon.

  ![Alt](images/lab%232-1.gif)

- Add a scroll bar that will change any visible parameter of any other element (color of a text).

  I used swipe events. I created a new class for swipeTouch

  ```
  public class OnSwipeTouchListener implements RelativeLayout.OnTouchListener {
      private final GestureDetector gestureDetector;
      public OnSwipeTouchListener (Context ctx){
          gestureDetector = new GestureDetector(ctx, new GestureListener());
      }
      @Override
      public boolean onTouch(View v, MotionEvent event) {
          return gestureDetector.onTouchEvent(event);
      }
      private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
          private static final int SWIPE_THRESHOLD = 100;
          private static final int SWIPE_VELOCITY_THRESHOLD = 100;
          @Override
          public boolean onDown(MotionEvent e) {
              return true;
          }
          @Override
          public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
              boolean result = false;
              try {
                  float diffY = e2.getY() - e1.getY();
                  float diffX = e2.getX() - e1.getX();
                  if (Math.abs(diffX) > Math.abs(diffY)) {
                      if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                          if (diffX > 0) {
                              onSwipeRight(diffX);
                          } else {
                              onSwipeLeft(diffX);
                          }
                          result = true;
                      }
                  }
                  else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                      if (diffY > 0) {
                          onSwipeBottom(diffX);
                      } else {
                          onSwipeTop(diffX);
                      }
                      result = true;
                  }
              } catch (Exception exception) {
                  exception.printStackTrace();
              }
              return result;
          }
      }
      public void onSwipeRight(float diff) {
      }
      public void onSwipeLeft(float diff) {
      }
      public void onSwipeTop(float diff) {
      }
      public void onSwipeBottom(float diff) {
      }
  }
  ```
