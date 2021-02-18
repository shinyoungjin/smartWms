# 온라인몰 배송물류관리시스템(WarehouseManagementSystem)
[Smart-WMS]

![image](https://user-images.githubusercontent.com/77368724/108147670-a5cda580-7112-11eb-89b0-0dfa32a07296.png)

# 서비스 시나리오

`기능적 요구사항`
1. 고객은 온라인몰에서 상품을 주문한다.
1. 주문이 완료되면, 배송센터에 출고지시가 생성되어진다.
1. 출고지시가 완료되면, 고객은 배송 진행상태를 알수 있다.
1. 출고지시가 완료되면, 상품 재고에 해당 재고를 할당(Assignment) 처리한다.
1. 출고지시가 완료되면, 피킹지시(Picking)가 생성이 된다.
1. 피킹지시가 완료되면, 패킹지시(Packing)가 생성이 된다.
1. 패킹지시가 완료되면, 재고할당을 풀고, 재고를 처리한다.
1. 고객은 주문을 취소할 수 있다.
1. 고객은 주문 상태를 조회할 수 있다.
1. 담당자는 배송센터 처리 건수를 조회 할수 있다.
1. 상품이 입력이 되면, 재고를 증가시킨다.
  
`비기능적 요구사항`
1. 트랜잭션
    1. 고객의 주문 취소시 배송 출고지시 취소가 완료된 이후 주문 취소 처리가 가능하다.(Sync)
    1. 주문 완료 이후 배송센터에 출고지시 전달한다.(Async,Correlation)
    1. 출고지시 완료 후 고객(주문Entity)에게 배송상태를 전달한다.(Async, Saga)
    1. 상품이 등록이 되면 재고 테이블에 데이터를 전달한다.(Async)
1. 장애격리
    1. 출고지시 시스템이 과중되면 주문 취소를 받지 않고 잠시후에 하도록 유도한다(Circuit breaker, fallback)
    1. 배송 센터의 출고지시 서비스가 중단되더라도 주문은 받을 수 있다.(Asyncm, Event Dirven)
1. 성능
    1. 고객이 주문 상황을 조회할 수 있도록 별도의 view로 구성한다.(CQRS)
    1. 담당자는 물류센터 상황을 조회할 수 있도록 별도의 view로 구성한다.(CQRS)


　    
  
  
# 체크포인트

1. Saga
1. CQRS
1. Correlation
1. Req/Resp
1. Gateway
1. Deploy/ Pipeline
1. Circuit Breaker
1. Autoscale (HPA)
1. Zero-downtime deploy (Readiness Probe)
1. Config Map/ Persistence Volume
1. Polyglot
1. Self-healing (Liveness Probe)  

　  
  
# 분석/설계

### Event Storming 결과
![image](https://user-images.githubusercontent.com/77368724/108155361-16c88980-7122-11eb-97a9-43f8a0ec4344.png)
　  
　     
### 기능적 요구사항 검증(1)

![image](https://user-images.githubusercontent.com/77368724/108157575-6c9f3080-7126-11eb-942e-c872371b087d.png)

    - 고객이 온라인몰에서 상품을 주문한다.(OK)
    - 주문이 완료되면, 배송센터에 출고지시가 생성되어진다.(OK)
    - 출고지시가 완료되면, 고객은 배송 진행상태를 알수 있다.(OK)
    - 출고지시가 완료되면, 상품 재고에 해당 재고를 할당(Assignment) 처리한다.(OK)
    - 출고지시가 완료되면, 피킹지시(Picking)가 생성이 된다.(OK)
    - 피킹지시가 완료되면, 패킹지시(Packing)가 생성이 된다.(OK)
    - 패킹지시가 완료되면, 재고할당을 풀고, 재고를 처리한다.(OK)
    - 상품이 입력이 되면, 재고를 증가시킨다.(OK)
    　  
　  
### 기능적 요구사항 검증(2)   
![image](https://user-images.githubusercontent.com/77368724/108157080-4a58e300-7125-11eb-9f12-40300ee7fdff.png)

    - 고객은 주문을 취소할 수 있다.(OK) 
    
　  
### 기능적 요구사항 검증(3)   
![image](https://user-images.githubusercontent.com/77368724/108157107-55137800-7125-11eb-9091-45edc65736e1.png)

    - 고객은 주문 상태를 조회할 수 있다.(OK)
    - 담당자는 배송센터 처리 건수를 조회 할수 있다.(OK)
    
   
### 비기능 요구사항 검증

    - 고객의 주문 취소시 배송 출고지시 취소가 완료된 이후 주문 취소 처리가 가능하다.(Req/Res)
    - 주문 완료 이후 배송센터에 출고지시 전달한다.(Pub/Sub)
    - 출고지시 완료 후 고객(주문Entity)에게 배송상태를 전달한다.(Async, Saga)
    - 상품이 등록이 되면 재고 테이블에 데이터를 전달한다.(Pub/Sub)
    - 출고지시 시스템이 과중되면 주문 취소를 받지 않고 잠시후에 하도록 유도한다(Circuit breaker, fallback)
    - 배송 센터의 출고지시 서비스가 중단되더라도 주문은 받을 수 있다.(Asyncm, Event Dirven)
    - 고객이 주문 상황을 조회할 수 있도록 별도의 view로 구성한다.(CQRS)
    - 담당자는 물류센터 상황을 조회할 수 있도록 별도의 view로 구성한다.(CQRS)
　  
   
   
   
   
# 구현

서비스를 로컬에서 실행하는 방법은 아래와 같다
- 각자의 포트넘버는 8081 ~ 8088 이다
- 주문,주문취소,출고지시,피킹지시,패킹지시,재고관리,상품관리,고객센터,배송센터 등

```
cd order
mvn spring-boot:run

cd deliveryOrder
mvn spring-boot:run  

cd deliveryPicking
mvn spring-boot:run 

cd deliveryPacking
mvn spring-boot:run 

cd product
mvn spring-boot:run 

cd stock
mvn spring-boot:run 

cd customerCenter
mvn spring-boot:run 

cd deliveryCenter
mvn spring-boot:run 

```
    
　  
　  
   
### DDD 의 적용

- 각 서비스내에 도출된 핵심 Aggregate Root 객체를 Entity 로 선언하였다. (예는 DeliveryOrder Microservice)

![image](https://user-images.githubusercontent.com/77368724/108159052-91e16e00-7129-11eb-8228-12ebb543180b.png)
    
   
- Entity Pattern 과 Repository Pattern 을 적용하여 JPA 를 통하여 다양한 데이터소스 유형 (RDB or NoSQL) 에 대한 별도의 처리가 없도록 데이터 접근 어댑터를 자동 생성하기 위하여 Spring Data REST 의 RestRepository 를 적용하였다

![image](https://user-images.githubusercontent.com/77368724/108159236-eedd2400-7129-11eb-8780-a0673f8c145d.png)


- 적용 후 REST API 의 테스트

```
# order 서비스(주문)의 주문 입력
http localhost:8081/orders orderId=1 productId=100 orderStatus=Ordered productName=TV orderQty=1

# order 서비스(주문)의 주문 확인
http localhost:8081/orders/1

# deliveryOrder 서비스(출고지시)의 출고지시 현황
http localhost:8082/deliveryOrders/1

```





# Polyglot

- "Order,DeliveryOrder,DeliveryPicking,DeliveryPacking,Stock,Product"는 H2로 구현하고, "CustomerCenter,DeliveryCenter" 서비스의 경우 Hsql로 구현하여 MSA간의 서로 다른 종류의 Database에도 문제없이 작동하여 다형성을 만족하는지 확인하였다.

- Order, DeliveryOrder, DeliveryPicking, DeliveryPacking, Stock, Product의 pom.xml 파일 설정

![image](https://user-images.githubusercontent.com/77368724/108161515-90667480-712e-11eb-821c-7f9dcbeb35b9.png)

 
- CustomerCenter, DeliveryCenter의 pom.xml 파일 설정

![image](https://user-images.githubusercontent.com/77368724/108161396-49787f00-712e-11eb-97be-c7f9a98848df.png)






# Req/Resp
```
1. 분석단계에서의 조건 중 하나로 "주문(order) 취소 → 출고지시(deliveryOrder)취소" 간의 호출은 동기식 일관성을 유지하는
트랜잭션으로 처리하기로 하였다.

2. 호출 프로토콜은 이미 앞서 Rest Repository 에 의해 노출되어있는 REST 서비스를 FeignClient 를 이용하여 
호출하도록 한다. 
```
    
    
- 출고지시 서비스를 호출하기 위하여 Stub과 (FeignClient) 를 이용하여 Service 대행 인터페이스 (Proxy) 를 구현  (DeliveryOrderService.java)

![image](https://user-images.githubusercontent.com/77368724/108170266-48028300-713d-11eb-8bec-e203e6f5c9d1.png)

    

- "주문 취소"를 받은 직후(@PostPersist) "출고지시 취소"를 요청하도록 처리

![image](https://user-images.githubusercontent.com/77368724/108170516-9879e080-713d-11eb-8c43-0dd86bcf13c7.png)
    
　  
　  
### 동기식 결제 장애시

```
# 출고지시(deliveryOrder) 서비스를 잠시 내려놓음
kubectl delete deploy deliveryorder -n skuser07
```

```
# 동기식 호출에서는 호출 시간에 따른 타임 커플링이 발생하며, "출고지시(deliveryOrder)" 시스템이 장애가 나면 "주문 취소"를 진행하지 못함
```
![image](https://user-images.githubusercontent.com/77368724/108172777-95342400-7140-11eb-93bc-db0638183130.png)
![image](https://user-images.githubusercontent.com/77368724/108172903-c3196880-7140-11eb-89dc-9cdfbdea5a6f.png)
　  
```
# 출고지시(deliveryOrder)서비스 재기동
kubectl create deploy deliveryorder --image=skuser07acr.azurecr.io/deliveryorder:latest -n skuser07
```
![image](https://user-images.githubusercontent.com/77368724/108173185-2acfb380-7141-11eb-8585-19a22d76f55b.png)
    
　  
    


# Gateway

- gateway > application.yml

![image](https://user-images.githubusercontent.com/77368724/108174719-286e5900-7143-11eb-8fae-179450a7be10.png)
    
　  
　  
- Gateway의 External-IP 확인

![image](https://user-images.githubusercontent.com/77368724/108174871-5eabd880-7143-11eb-83a0-7542b1859e13.png)
    
　  
　  
- External-IP 로 Order 서비스에 접근

![image](https://user-images.githubusercontent.com/77368724/108175106-ad597280-7143-11eb-86d3-36d88db1b1d6.png)
    
　  
　      


# Deploy

- Deploy API 호출

```
# Namespace 생성
kubectl create ns skuser07

# 소스를 가져와 각각의 MSA 별로 빌드 진행

# 도커라이징 : Azure Registry에 Image Push 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/order:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/deliveryorder:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/deliverypicking:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/deliverypacking:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/product:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/stock:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/customercenter:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/deliverycenter:latest . 
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/gateway:latest . 

# 컨테이터라이징 : Deploy, Service 생성
kubectl create deploy order --image=skuser07acr.azurecr.io/order:latest -n skuser07
kubectl expose deploy order --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy deliveryorder --image=skuser07acr.azurecr.io/deliveryorder:latest -n skuser07
kubectl expose deploy deliveryorder --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy deliverypicking --image=skuser07acr.azurecr.io/deliverypicking:latest -n skuser07
kubectl expose deploy deliverypicking --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy deliverypacking --image=skuser07acr.azurecr.io/deliverypacking:latest -n skuser07
kubectl expose deploy deliverypacking --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy product --image=skuser07acr.azurecr.io/product:latest -n skuser07
kubectl expose deploy product --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy stock --image=skuser07acr.azurecr.io/stock:latest -n skuser07
kubectl expose deploy stock --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy customercenter --image=skuser07acr.azurecr.io/customercenter:latest -n skuser07
kubectl expose deploy customercenter --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy deliverycenter --image=skuser07acr.azurecr.io/deliverycenter:latest -n skuser07
kubectl expose deploy deliverycenter --type="ClusterIP" --port=8080 -n skuser07

kubectl create deploy gateway --image=skuser07acr.azurecr.io/gateway:latest -n skuser07
kubectl expose deploy gateway --type="LoadBalancer" --port=8080 -n skuser07

#kubectl get all -n skuser07
```
    　  
　  
- Deploy 확인

![image](https://user-images.githubusercontent.com/77368724/108175822-8a7b8e00-7144-11eb-9d10-41156d515025.png)
    
　  
　  


# Circuit Breaker
```
1. 서킷 브레이킹 프레임워크의 선택: Spring FeignClient + Hystrix 옵션을 사용하여 구현함.  
2. 시나리오는 주문(order)-->출고지시(deliveyOrder) 시의 연결을 RESTful Request/Response 로 연동하여 구현이 되어있고, 예치금 결제 요청이 과도할 경우 CB 를 통하여 장애격리.  
3. Hystrix 를 설정: 요청처리 쓰레드에서 처리시간이 300 밀리가 넘어서기 시작하여 어느정도 유지되면 CB 회로가 닫히도록 (요청을 빠르게 실패처리, 차단) 설정
```


- application.yml 설정

![image](https://user-images.githubusercontent.com/77368724/108197876-46958280-715e-11eb-9fce-74fa3746396f.png)

    
　  
- 피호출 서비스 "출고지시(deliveyOrder)" 의 임의 부하 처리  Order.java(entity)

![image](https://user-images.githubusercontent.com/77368724/108282750-79bf2c80-71c5-11eb-931f-7d941ccab9a4.png)

　  

`$ siege -c200 -t120S -r10 -v --content-type "application/json" 'http://52.231.9.112:8080/orders POST {"orderId": "1","productId":"500", "orderStatus":"Ordered"}'`

- 부하테스터 siege 툴을 통한 서킷 브레이커 동작 확인 (동시사용자 200명, 120초 진행)

![image](https://user-images.githubusercontent.com/77368724/108197378-a63f5e00-715d-11eb-9f72-ab013b4f368c.png)
```
* 요청이 과도하여 CB를 동작함 요청을 차단
* 요청을 어느정도 돌려보내고나니, 기존에 밀린 일들이 처리되었고, 회로를 닫아 요청을 다시 받기 시작
* 다시 요청이 쌓이기 시작하여 건당 처리시간이 610 밀리를 살짝 넘기기 시작 => 회로 열기 => 요청 실패처리
```
　  
　  
![image](https://user-images.githubusercontent.com/77368724/108197558-e272be80-715d-11eb-995a-904d4d258a55.png)

`운영시스템은 죽지 않고 지속적으로 CB 에 의하여 적절히 회로가 열림과 닫힘이 벌어지면서 자원을 보호하고 있음을 보여줌`
    
　  
　  


# Auto Scale(HPA)
```
1. 앞서 CB 는 시스템을 안정되게 운영할 수 있게 해줬지만 사용자의 요청을 100% 받아들여주지 못했기 때문에 
이에 대한 보완책으로 자동화된 확장 기능을 적용하고자 한다.  
2. 출고지시 서비스에 대한 replica 를 동적으로 늘려주도록 HPA 를 설정한다. 설정은 CPU 사용량이 15프로를 
넘어서면 replica 를 10개까지 늘려준다.
```

- 테스트를 위한 리소스 할당(order > deployment.yml)

![image](https://user-images.githubusercontent.com/77368724/108195363-0254b300-715b-11eb-87f5-44d2e80e2715.png)
    
　  
　  
### autoscale out 설정 

- kubectl autoscale deploy order --min=1 --max=10 --cpu-percent=15 -n skuser07

![image](https://user-images.githubusercontent.com/77368724/108225449-4b1e6300-717f-11eb-820b-9be8d1f97837.png)
    
　  
　  
- CB 에서 했던 방식대로 워크로드를 1분 동안 걸어준다.

`$ siege -c100 -t60S -r10 -v --content-type "application/json" 'http://52.231.9.112:8080/orders POST {"orderId": "1","productId":"500", "orderStatus":"DeliveryOrderCanceled"}' `

　  
- 오토스케일이 어떻게 되고 있는지 모니터링을 걸어둔다:

`watch kubectl get all -n skuser07`

　  
- 어느정도 시간이 흐른 후 (약 30초) 스케일 아웃이 벌어지는 것을 확인할 수 있다:

![image](https://user-images.githubusercontent.com/77368724/108226438-43ab8980-7180-11eb-877e-7a0b878fcdfd.png)
    
　  
　  
    
   
# Zreo-Downtown Deploy

* 먼저 무정지 재배포가 100% 되는 것인지 확인하기 위해서 Autoscale 나 CB 설정을 제거함

- seige 로 배포작업 직전에 워크로드를 모니터링 함.

`siege -c200 -t120S -r10 -v --content-type "application/json" 'http://52.231.9.112:8080/orders POST {"orderId": "1","productId":"500", "orderStatus":"Ordered"}'`
    

- 새버전으로의 배포 시작
```
az acr build --registry skuser07acr --image skuser07acr.azurecr.io/order:r1 . 
kubectl set image deploy order order=skuser07acr.azurecr.io/order:r1 -n skuser07
```
　  
### readiness 옵션이 없는 경우 배포 중 서비스 요청처리 실패

![image](https://user-images.githubusercontent.com/77368724/108208220-181ea400-716c-11eb-9840-a788c940dbce.png)
    
   
### readiness 옵션 추가

- deployment.yaml 의 readiness probe 의 설정

![image](https://user-images.githubusercontent.com/77368724/108209006-1c978c80-716d-11eb-9463-405a40c684c1.png)
　  
　  
```
# readiness 적용 이미지 배포
kubectl apply -f deployment.yml
# 이미지 변경 배포 한 후 Availability 확인:
```
　  
- 배포기간 동안 Availability 가 변화없기 때문에 무정지 재배포가 성공한 것으로 확인됨.

![image](https://user-images.githubusercontent.com/77368724/108210402-d93e1d80-716e-11eb-8cf3-0ca64d29d564.png)
    
　  
　 
  
   　  　  
# Self-healing (Liveness Probe)

- deployment.yml 에 Liveness Probe 옵션 추가

![image](https://user-images.githubusercontent.com/77368724/108221109-c7fb0e00-717a-11eb-8573-24e325dee34b.png)
    
　  
　  
- order pod에 liveness가 적용된 부분 확인

![image](https://user-images.githubusercontent.com/77368724/108221361-0ee90380-717b-11eb-9feb-f094af70a201.png)

    
　  
　  
- order 서비스의 liveness가 발동되어 5번 retry 시도 한 부분 확인

![image](https://user-images.githubusercontent.com/77368724/108221762-7ef78980-717b-11eb-940b-db373c62c98a.png)

