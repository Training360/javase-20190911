class: inverse, center, middle

# Metódusok kezelése reflectionnel

---

# Metódusok

```java
Method[] methods = Trainer.class.getMethods();
Method method =
        Trainer.class.getMethod("setName", String.class);
Class[] parameterTypes = method.getParameterTypes();
Class returnType = method.getReturnType();
```

* Ha nincs: `NoSuchMethodException`

---

# Metódusok tulajdonságai

* `String getName()`
* `getDeclaringClass()`
* `getModifiers()`
* `getExceptionTypes()`
* `getParameterCount()`, `getParameterTypes()`
* `isSynthetic()`
* `isDefault()`
* `isVarArgs()`

---

# Metódus hívása

```java
Trainer trainer = new Trainer();

Method setter =
        Trainer.class.getMethod("setName", String.class);
setter.invoke(trainer, "John Doe");

Method getter =
        Trainer.class.getMethod("getName");
String name = (String) getter.invoke(trainer);

System.out.println(name);
```

* Statikus esetén objektumként `null` adandó át
* A `private` metódus hívása előtt <br /> `setAccessible(true)`

---

# Paraméter nevek lekérdezése

* Java 8-ig nem lehet Reflection API-val lekérdezni
* Ha debug módban kerül lefordításra a forráskód, a bájtkódba belekerül
  * Pl. ObjectWeb ASM könyvtár a bájtkód analizálásával ki tudja olvasni
* Java 8-ban sem alapbeállítás

```java
System.out.println(setter.getParameters()[0].getName()); // arg0
```

---

# Paraméter nevek lekérdezése

* Java 8 óta fordító kapcsoló `-parameters`
* Maven esetén `maven-compiler-plugin` konfigurációval

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
        <compilerArgs>
            <arg>-parameters</arg>
        </compilerArgs>
    </configuration>
</plugin>
```
