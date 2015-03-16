### Scheisse Server

Server backend for the game.

## Features:

* Item loading over web service: Items are loaded via web service instead of local files.

* User login: Login credentials can be checked via web service. Successfully logged in users get a session token.

* Web interface: All user specific data like inventory or shopping can be done in a web browser.

# Item Loading:

Loading Items from the Web Service is easy and pretty much intuitive. You only need the id of the Item you want to load
or you can just load all Items at once. Here's an example:

```java
ItemService itemService = new ItemServiceClient();

//load one item:
Item item = ItemContainer.convertBack(itemService.get(1));

//load all items:
List<item> items = ItemContainer.convertBack(itemService.getAll());
```