# Bulat Material CounterView
Счетчик.
Дизайн : Евгений Булатов
Разработка: Антон Кондратюк

Что можно:
- 2 режима: intValues, floatValues
- Изменение шага

Прочие настройки:
```java
        app:minusString="-"
        app:plusString="+"
        app:maxValue="500"
        app:minValue="0"
        app:diff="1"
        app:type="intValues"
        app:value="8"
        app:primaryColor="@color/background"
        app:secondaryColor="@color/alpha_background"
        app:separatorColor="@color/separator"
```
Аналогичный функционал для задания данных настроек программно.

Подключение
----
Добавьте в настройки проекта:

```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

И в основной gradle:

```gradle
	dependencies {
	        compile 'com.github.Merlinkoss:bulatmaterialcounterview:master-SNAPSHOT'
	}
```

License
----

MIT

**Free Software, Hell Yeah!**
