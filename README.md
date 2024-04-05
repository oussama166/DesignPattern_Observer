
# Design pattern : Observer
Also known as: ***Event-Subscriber, Listener***

## Intent

__Observer__ is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

![](C:\Users\hp\Documents\Devloppements\PatternDesign\Observer\src\main\resources\assets\observer-2x.png)

## Problem 

Imagine that you have two types of objects: a `Customer` and a `Store`. The customer is very interested in a particular brand of product (say, it’s a new model of the iPhone) which should become available in the store very soon.

The customer could visit the store every day and check product availability. But while the product is still en route, most of these trips would be pointless.

![Visiting the store vs. sending spam](C:\Users\hp\Documents\Devloppements\PatternDesign\Observer\src\main\resources\assets\observer-comic-1-en-2x.png)

On the other hand, the store could send tons of emails (which might be considered spam) to all customers each time a new product becomes available. This would save some customers from endless trips to the store. At the same time, it’d upset other customers who aren’t interested in new products.

It looks like we’ve got a conflict. Either the customer wastes time checking product availability or the store wastes resources notifying the wrong customers.

## Solution
The object that has some interesting state is often called subject, but since it’s also going to notify other objects about the changes to its state, we’ll call it publisher. All other objects that want to track changes to the publisher’s state are called subscribers.

The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can subscribe to or unsubscribe from a stream of events coming from that publisher. Fear not! Everything isn’t as complicated as it sounds. In reality, this mechanism consists of 
1. an array field for storing a list of references to subscriber objects and 
2. several public methods which allow adding subscribers to and removing them from that list.

![Visiting the store vs. sending spam](C:\Users\hp\Documents\Devloppements\PatternDesign\Observer\src\main\resources\assets\solution1-en-2x.png)
Now, whenever an important event happens to the publisher, it goes over its subscribers and calls the specific notification method on their objects.

Real apps might have dozens of different subscriber classes that are interested in tracking events of the same publisher class. You wouldn’t want to couple the publisher to all of those classes. Besides, you might not even know about some of them beforehand if your publisher class is supposed to be used by other people.

That’s why it’s crucial that all subscribers implement the same interface and that the publisher communicates with them only via that interface. This interface should declare the notification method along with a set of parameters that the publisher can use to pass some contextual data along with the notification.

![Visiting the store vs. sending spam](C:\Users\hp\Documents\Devloppements\PatternDesign\Observer\src\main\resources\assets\solution2-en-2x.png)

If your app has several different types of publishers and you want to make your subscribers compatible with all of them, you can go even further and make all publishers follow the same interface. This interface would only need to describe a few subscription methods. The interface would allow subscribers to observe publishers’ states without coupling to their concrete classes.

#  # Pseudocode
In this example, the __Observer__` pattern lets the text editor object notify other service objects about changes in its state.

![Visiting the store vs. sending spam](C:\Users\hp\Documents\Devloppements\PatternDesign\Observer\src\main\resources\assets\example-2x.png)

# Example

---

### Observer in Java

> *__Observer__* is a behavioral design pattern that allows some objects to notify other objects about changes in their state.

- **Complexity** : 2/3

- **popularity** : 3/3


**Usage example** :The Observer pattern is pretty common in Java code, especially in the GUI components. It provides a way to react to events happening in other objects without coupling to their classes.


Here are some examples of the pattern in core Java libraries:

* `java.util.Observer/java.util.Observable` (rarely used in real world)
* All implementations of `java.util.EventListener` (practically all over Swing components)
* `javax.servlet.http.HttpSessionBindingListener`
* `javax.servlet.http.HttpSessionAttributeListener`
* `javax.faces.event.PhaseListener`

### Event subscription

>In this example, the Observer pattern establishes indirect collaboration between objects of a text editor. Each time the `Editor` object changes, it notifies its subscribers. `EmailNotificationListener` and `LogOpenListener` react to these notifications by executing their primary behaviors.

> Subscriber classes aren’t coupled to the editor class and can be reused in other apps if needed. The `Editor` class depends only on the `abstract subscriber` interface. This allows adding new subscriber types without changing the editor’s code.