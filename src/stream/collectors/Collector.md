 # Collectors
 ### Stream -> intermediate evaluation -> terminal evaluation  
 * List 나 Map 과 같은 자료구조에 담고 싶을때  또는 통계를 작성하고 싶으때 활용
```java
stream.collect(Collector<? super T, A, R> collector);
```
 
<table>
<tr>
    <th>기능</th>
    <th>Example</th>
    <th>Description</th>
    <th>Return Type</th>
</tr>
<!-- list -->
<tr>
    <td rowspan="2">List로 수집</td>
    <td>toList()</td>
    <td>Stream to editable List</td>
    <td rowspan="2">List&lt;T&gt;</td>
</tr>
<tr>
    <td>toUnmodifiableList()</td>
    <td>Stream to none editable list</td> 
</tr>
<!-- Set -->
<tr>
    <td rowspan="2">Set으로 수집</td>
    <td>toSet()</td>
    <td>스트림요소를 Set으로 모으고, 중복은 자동제거됨</td>
    <td>Set&lt;T&gt;</td>
</tr>
<tr>
    <td>toCollection(HashSet::new)</td>
    <td>특정 Set타입으로 모으려면 toCollection()을 사용</td>
</tr>
<!-- Map -->
<tr>
    <td rowspan="2">Map으로 수집</td>
    <td>toMap(KeyMapper, ValueMapper)</td>
    <td>스트림요소를 Map에 (key, Value)형태로 수집</td>
    <td rowspan="2"> Map&lt;K,&nbsp;V&gt;</td>
</tr>
<tr>
    <td>toMap(KeyMapper, ValueMapper, mergeFunction, mapSupplier)</td>
    <td>중복키가 생기면, mergeFunction으로 해결하고, mapSupplier로 맵타입 지정</td>
</tr>
<!-- 그룹화 -->
<tr>
    <td rowspan="2">그룹화</td>
    <td>groupingBy(classifier)</td>
    <td>특정 기준 함수(Classifier)에 따라 그룹별로 스트림요소를 묶음</td>
    <td>Map&lt;K,&nbsp;List&lt;T&gt;&gt;</td>
</tr>
<tr>
    <td>groupingBy(classifier, downstreamCollector)</td>
    <td>그룹별 적용할 down stream collector을 지정</td>
    <td>또는 Map&lt;K,&nbsp;&gt></td>
</tr>
<!-- 분할 -->
<tr>
    <td rowspan="2">분할</td>
    <td>partitioningBy(predicate)</td>
    <td>predicate 결과가 true/false 두가지로 나눔</td>
    <td>Map&lt;Boolean,List&lt;T&gt;&gt;</td>
</tr>
<tr>
    <td>partitionBy(predicate, downstreamCollector></td>
    <td>predicate결과를 true/false로 나누고 collection아 아닌 다른결과 </td>
    <td>Map&lt;Boolean,(Integer,String etc..)&gt;</td>
</tr>
<tr>
    <td rowspan="4">통계</td>
    <td>counting()</td>
    <td>요소의 갯수</td>
    <td rowspan="3">Long, Integer, Double</td>
</tr>
<tr>
    <td>summingInt()</td>
    <td>합계</td>
</tr>
<tr>
    <td>averagingInt()</td>
    <td>평균</td>
</tr>
<tr>
    <td>summarizingInt() etc..</td>
    <td>통계</td>
    <td>IntSummaryStatistics</td>
</tr>
<tr>
    <td>Reducing</td>
    <td>reducing()</td>
    <td>Stream의 reduce()와 유사하게 Collector환경에서 요소를 합치는 연산</td>
    <td></td>
</tr>
<tr>    
    <td>문자열 연결</td>
    <td>joining(delimiter, prefix, suffix)</td>
    <td>문자열 스트림을 하나로 합쳐서 연결함. delimiter, prefix, suffix와 결합가능</td>
    <td></td>
</tr>
<tr>
    <td>매핑</td>
    <td>mapping(mapper, downstream)</td>
    <td>각 요소를 다른 값으로 매핑(mapper)한 후 downstream 컬랙터로 전환</td>
</tr>
</table>
   
   

 
  