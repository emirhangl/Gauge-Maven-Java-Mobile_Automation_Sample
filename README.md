# Gauge-Maven-Java-Mobile_Automation_Sample

## Gauge CLI ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 
Tag name’e göre execute edip test ortamımızı belirliyoruz:
mvn clean test -Dtags=“$tag_name” -Denv="firefox"


## Specs List Handling ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 
**exapmle.spec dosyasının içindeki senaryoları listele:**
```
gauge list --scenarios specs/example.spec
```

**Specs dizinindeki bütün senaryoları listele:**
```
gauge list --scenarios specs
```

**Specs dizinindeki bütün Specification’ları listele:**
```
gauge list --specs specs
```

**example.spec dosyasının içindeki specification’ları listele:**
```
gauge list --specs specs/example.spec
```

**Specs dizinindeki bütün Tag’leri listele:**
```
gauge list --tags specs
```

**example.spec dosyasındaki bütün Tag’leri listele:**
```
gauge list --tags specs/example.spec
```

## Executing Specs ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) 
*”mvn clean test” diyip parametreleri geçince projenin Target’ini silip yeniden build ediyor. Diğer türlü hep önceki Build’i kullanıyor.*

**Specs dizinindeki bütün specleri koşmak için:**
```
mvn gauge:execute -DspecsDir=specs
mvn clean test -DspecsDir=specs
```

**Specific bir spec koşmak için:**
```
mvn gauge:execute -DspecsDir=specs/example.spec
mvn clean test -DspecsDir=specs/example.spec
```

**Farklı dizinlerdeki specleri koşmak için:**
```
mvn gauge:execute -DspecsDir="specs,specDir"
mvn clean test -DspecsDir="specs,specDir"
```

**Hatalı bitmiş testleri koşmak için:**
```
mvn gauge:execute -Dflags="--failed"
mvn clean test -Dflags="--failed"
```

**Bir önceki koşulan senaryoları tekrardan koşmak için:**
```
mvn gauge:execute -Dflags="--repeat"
mvn clean test -Dflags="--repeat"
```

**Tag’e göre koşmak için:**
```
mvn clean test -Dtags=loginol
mvn clean test -Dtags=“loginol,blabla,blabla”
```

**Bir Spec’te specific bir senaryo koşmak için:**
```
 mvn clean test -DspecsDir=specs/deneme.spec:9
“:9” hangi senaryoyu koşmak istiyorsak, ilgili step’in satır numarasını belirtiyoruz.
```








