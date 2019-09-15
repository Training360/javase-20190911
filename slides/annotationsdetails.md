class: inverse, center, middle

# Részletesen az annotációkról

---

# Hol használhatóak?

* Csomag
* Osztályok, interfészek, enumok deklarációjánál
* Attribútumok, konstruktorok, metódusok deklarációjánál
* Metódus paramétereknél
* Lokális változóknál
* Annotációkon

---

# Saját annotáció element-ekkel

```java
@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatedField {

    String value() default "";

    Class[] validators() default {};
}
```

---

# Saját annotáció használata

```java
@ValidatedField
private String name;
```

```java
@ValidatedField("trainer name")
private String name;
```

```java
@ValidatedField(value = "trainer name", classes = NotNullValidator.class)
private String name;
```

```java
@ValidatedField(value = "Name", 
    classes = {NotNullValidator.class, NameValidator.class})
private String name;
```

---

# Annotáció feldolgozása reflecionnel

```java
Field[] fields = Trainer.class.getDeclaredFields();
for (Field field: fields) {
    ValidatedField validatedField = field.getAnnotation(ValidatedField.class);
    if (validatedField != null) {
        Class<? extends Validator>[] validators = validatedField.validators();
        System.out.println(validatedField.value() + " - " +  Arrays.toString(validators));
    }
}
```
---

# Osztály, interfész, enum annotációk

```java
Annotation[] annotations = Trainer.class.getAnnotations();

Annotation annotation = Trainer.class.getAnnotation(ValidatedClass.class);
System.out.println(annotation.value());
```

---

# Attribútum annotációk

```java
Annotation[] annotations = Trainer.class.getField("name").getAnnotations();

Annotation annotation = Trainer.class.getField("name").getAnnotation(ValidatedField.class);
```

---

# Metódus annotációk

```java
Annotation[] annotations = Trainer.class.getMethod("getName").getAnnotations();

Annotation annotation = Trainer.class.getMethod("getName").getAnnotation(ValidatedResult.class);
```

---

# Paraméter annotációk

```java
Method method = ... //obtain method object
Annotation[][] parameterAnnotations = method.getParameterAnnotations();
Class[] parameterTypes = method.getParameterTypes();

int i=0;
for (Annotation[] annotations: parameterAnnotations){
  Class parameterType = parameterTypes[i++];

  for (Annotation annotation: annotations){
    if (annotation instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotation;
        System.out.println("param: " + parameterType.getName());
        System.out.println("name : " + myAnnotation.name());
        System.out.println("value: " + myAnnotation.value());
    }
  }
}
```

---

# Type annotation

* Java 8 óta _type annotation_
* Példányosításnál

```java
new @Interned MyObject();
```

* Típuskényszerítésnél

```java
myString = (@NonNull String) str;
```

---

# Type annotation

* Interfész implementáláskor

```java
class UnmodifiableList<T> implements
    @Readonly List<@Readonly T> { ... }
```

* Metódusban kivételek deklarációjánál

```java
void monitorTemperature() throws
    @Critical TemperatureException { ... }
```

---

# Type annotation használata

* Pluginelhető típus ellenőrzés
* Java nem tartalmaz ilyen keretrendszert
* Még erősebb típusosság
* [Checker Framework](https://checkerframework.org/)
