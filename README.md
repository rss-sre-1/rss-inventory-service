# RSS-Inventory-Service

### Implementing Inventory Service

* Clone the [rss-inventory-service repository](https://github.com/rss-sre-1/rss-inventory-service.git)
* Build image using provided [Dockerfile](https://github.com/rss-sre-1/rss-inventory-service/blob/documentation/Dockerfile)
  * `docker build -t rss-inventory-service .`
  * Push image to Dockerhub or ECR. Image may be retagged at this point.
    * `docker push rss-inventory-service:latest` 
  * Change image repository URL in [rss-inventory-setup.yaml](github.com/rss-sre-1/rss-inventory-service/blob/documentation/rss-inventory-setup.yaml) on line 207 and 282.
* Create a namespace called rss-inventory
  * `kubectl create namespace rss-inventory`
* Create environment variables DB_URL (database url), DB_USERNAME (database username) and DB_PASSWORD (database password)
* Create secret using previously created environment variables
  * `kubectl create -n rss-inventory secret generic rss-inventory-credentials --from-literal=url=$DB_URL --from-literal=username=$DB_USERNAME --from- literal=password=$DB_PASSWORD`
* Create fluentd configmap for logging using [fluent.conf](https://github.com/rss-sre-1/rss-inventory-service/blob/documentation/fluent.conf)
  * `kubectl create configmap -n rss-inventory fluent-conf --from-file fluent.conf`
* Apply the rss-inventory manifests to kubernetes
  * `kubectl apply -f rss-inventory-setup.yaml`
* Apply the following non-controller kubernetes objects (these are not in rss-inventory-setup.yaml)
  * rules - set up recording and alerting rules for Prometheus 
    * `kubectl apply rss-inventory-rules.yml`  
  * loki external- helps export the logs
    * `kubectl apply -f loki-external.yml` 
* Ensure all pods are running by doing a get all on the rss-inventory namespace. There should be 3 deployment pods with 2/2 containers ready.
  * `kubectl -n rss-inventory get all`    

This repository holds the inventory microservice which handles:

- product creation*
- product retrieval
- product updates
- product deletion

*creates test products as well as adds new products

These requests are handled by a single **ProductController.**


Endpoints and methods are mapped out below.

Feel free to import methods with this Postman [file.](RSS-Inventory-Service.postman_collection.json) Make sure to replace base url with your specific EKS DNS. 
EKS DNS can be found with the command `kubectl get ing`

#### Endpoints
VERB | URL | USE
--- | --- | ---
GET | /inventory/main | creates test products
GET | /inventory/product/{id} | gets product by id
GET | /inventory/product | gets a list of all the products
POST | /inventory/product | creates a new product
PUT | /inventory/product | updates a product
DELETE | /inventory/product/{id} | deletes a product by their id

#### Methods

``` java
public void getProductById()
```

> Creates test products.

``` java
public Product getProductById(@PathVariable Long id)
```

> Will return the product based on the given ID.

``` java
public List<Product> getAllProduct()
```

> Will return a list of all products.

``` java
public Product createProductById(@RequestBody Product product)
```

> Will create a new product.

``` java
public Product updateProduct(@RequestBody Product product)
```

> Will update a product.

``` java
public void deleteProductById(@PathVariable Long id)
```

> Will delete a product.

#### Product (model)

``` java
    private Long id;
    private String category;
    private String brand;
    private String name;
    private String description;
    private String model;
    private String image;
    private Integer quantity;
    private Integer unitPrice;
    private String color;

```
# Getting started
* If you already have Docker Desktop with Kubernetes running on your machine with the nginx-ingress service skip to the setup files portion of this walkthrough
* You need to have Docker installed on your computer. Install Docker [here](https://docs.docker.com/get-docker/).
* If you are running windows Docker Desktop is your quickest option.
* Enable Kubernetes on Docker Desktop in settings.
* Install Helm on your machine if you are using Windows. This will allow for the quick installation of the nginx-ingress. [Helm](https://helm.sh/docs/intro/install/) [nginx-ingress](https://github.com/kubernetes/ingress-nginx).
* Once you have the nginx-ingress in your Kubernetes services use `kubctl apply -f rss-inventory-setup.yaml` to deploy this service


# Viewing Changes Locally for Testing
* You must have a Dockerhub account. Use `docker build -t yourdockerhub/rss-inventory-service .` to build the Docker image and push that image to your Dockerhub.
* Change the image target in the rss-inventory-setup.yaml in the deployment section to use the image from your Dockerhub that you just pushed.
* Use `kubctl apply -f rss-inventory-setup.yaml` to redeploy your new image.
