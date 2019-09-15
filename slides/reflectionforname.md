class: inverse, center, middle

# Osztály referencia a neve alapján

---

# Osztály referencia a neve alapján

* `forName(String)` metódus használatával

```java
Class trainerClass = Class.forName("training.Trainer");
Constructor allArgsConstructor = trainerClass.getConstructor(String.class, int.class);
Trainer trainer = (Trainer) allArgsConstructor.newInstance("John Doe", 1970);
System.out.println(trainer.getName() + " " + trainer.getYearOfBirth());
```

* `ClassNotFoundException`, ha nincs