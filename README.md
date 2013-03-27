# GenericEventListeners for Java


## Usage

1. Derive your class from `Listenable`
```
class MyClass extends Listenable {
}
```

2. Use `addActionListener()` for registering for an event type and implement the `Listener` interface.
```
class Main {
  public static void main(String[] args) {
    MyClass myObj = new MyClass();
    myObj.addEventListener("dispatched", new Listener<String>() {
      
      public boolean run(Event<String> e) {
        System.out.println(e.data);
      }
    });
    myObj.doDispatch();
  }
}
```

3. Dispatch an event from your `Listenable` class:
```
class MyClass extends Listenable {
  public void doDispatch() {
    dispatchEvent( new Event<String>("dispatched", "Hello World!") );
  }
}
```

**Warning:** `dispatchEvent()` does **not** check whether the type of the dispatched Event (here `String`) and the registered listeners match!

<hr />

## About
Author: [@comfreek](http://twitter.com/comfreek)
<br />
License: MIT license, see `LICENSE` file for more information.