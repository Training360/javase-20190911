class: inverse, center, middle

# Kiírás Stringbe StringWriterrel

---

# StringWriter haszna

* Kiírás `String`-be
* Önmagában nem használjuk, hiszen arra ott a `StringBuilder`
* Ha létező metódus `Writer` példányt vár

---

# Írás közvetlenül

```java
StringWriter sw = new StringWriter();
try (sw) {
    for (String employee: employees) {
        sw.write(employee);
        sw.write(", ");
    }
}
catch (IOException ioe) {
    throw new IllegalStateException("Can not write", ioe);
}
System.out.println(sw.toString());
```

---

# Writert váró metódus

```java
public void writeTo(List<String> employees, Writer writer) {
    try {
        for (String employee : employees) {
            writer.write(employee);
            writer.write(", ");
        }
    } catch (IOException ioe) {
        throw new IllegalStateException("Can not read file", ioe);
    }
}
```

---

# Writert váró metódus használata

```java
<String> employees = List.of("John Doe", "Jane Doe", "Jack Doe");
try (BufferedWriter writer = Files.newBufferedWriter(Path.of("employees.txt"))) {
    writeTo(employees, writer);
} catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}

StringWriter stringWriter = new StringWriter();
try (stringWriter) {
    writeTo(employees, stringWriter);
} catch (IOException ioe) {
    throw new IllegalStateException("Can not write file", ioe);
}
System.out.println(stringWriter.toString());
```
