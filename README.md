# Publisoft-Supplier-Project
CRUD and REST API of the Supplier Entity

Firstly i created SupplierRepository class to extend JPA so to apply the basic methods of JPA(findById for example). 
Inside SuppplierRepository i wrote two methods find by vatNumber and find by Company name both of them returning a list of Suppliers.
Then i created a MainControllerClass to create the REST API.

I created all the reqeuests by order:
a) GET all suppliers
b) GET Suppliers by company name
c) GET Suppliers by vat number
d) POST(create) a supplier
e) PUT(update) a supplier
f) DELETE a supplier


Everything was tested with POSTMAN application checking all the requests. 

In the front - end part i tried to create Supplier.vue, Suppliers.vue, SupplierVM.js, SuppliersVM.js but i find it difficult to connect
due to my luck of knowledge in vue.js.
