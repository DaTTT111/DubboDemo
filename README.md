# Dubbo Demo on Alauda Cloud


A dubbo demo running on Alauda Cloud. 

## Dubbo-Admin
Code in [docker-admin](docker-admin)

### Where to get dubbo-admin-2.5.3.war
See: [dubbo 2.5.3 环境搭建](http://www.jianshu.com/p/6541f277f467)

### Unpack war to ROOT  
`unzip dubbo-admin-2.5.3.war -d ./ROOT`

### Build Docker Image
<pre>
cd docker-admin
docker build -t index.alauda.cn/claas/dubbo:alpine-jre8-tomcat8-dubbo2.5.3 .
</pre>

## Demo Provider & Demo Consumer
Code in [dubbo-demo](dubbo-demo).

Thanks to [binblee on github](https://github.com/binblee/dubbo-docker).

### Build demo
`mvn clean package`

### Build Provider Docker Image
<pre>
cd dubbo-demo/service-producer
docker build -t index.alauda.cn/claas/dubbo-demo-provider:dubbo2.5.3 .
</pre>

### Build Consumer Docker Image
<pre>
dubbo-demo/service-consumer
docker build -t index.alauda.cn/claas/dubbo-demo-consumer:dubbo2.5.3 .
</pre>

## Run on Alauda Cloud
Use [dubbo.yaml](dubbo.yaml) as template to create an application on Alauda Cloud.

### Zookeeper Cluster
* 3 nodes
* host network mode
* **Use IP address's of your own physical or virtual machines**

### DubboAdmin Webapp
* 2 nodes
* flannel network mode
* Default root password is **root**, or specify your own:
	* `DUBBO_ROOT_PASSWORD=yourposs`
* Default guest password is **guest**, or specify your own:
	* `DUBBO_GUEST_PASSWORD=yourposs`
* Use the following style for environment variable ZK_URL：
	* `ZK_URL=zoo1:2181?backup=zoo2:2181,zoo3:2181`
	* `ZK_URL=zoo1:2181`
* **NOT USE** the follows for ZK_URL：
	* `ZK_URL=zoo1:2181,zoo2:2181,zoo3:2181`

### Porvider & Consumer 
* 1 node respectively
* flannel network mode
* Use ZK_URL：
	* `ZK_URL=zoo1:2181,zoo2:2181,zoo3:2181`
	* `ZK_URL=zoo1:2181`

### Links Statements 
* The **links** statements indicate dependency relationship among services defined in [dubbo.yaml](dubbo.yaml). Use **Strict Mode** to create your application on Alauda Cloud.

### Verify 
create a ssh tunnel to the K8s master node mastering your dubbo-admin pod.
`ssh -L 8080:10.20.0.9:8080 alauda@40.125.206.147`

Open your browser to visit:
`http://localhost:8080/`
