# Bulat Material CounterView
Счетчик.
Дизайн : Евгений Булатов
Разработка: Антон Кондратюк

![example](https://github.com/Merlinkoss/bulatmaterialcounterview/blob/master/img/counter.png)

Что можно:
- 2 режима: intValues, floatValues
- Изменение шага

Прочие настройки:
```java
<com.goodboyapp.bulatmaterial.CounterView
        android:id="@+id/counterView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        app:bulat_diff="1"
        app:bulat_maxValue="500"
        app:bulat_minValue="0"
        app:bulat_minusString="-"
        app:bulat_plusString="+"
        app:bulat_primaryColor="@color/background"
        app:bulat_secondaryColor="@color/alpha_background"
        app:bulat_separatorColor="@color/separator"
        app:bulat_type="intValues"
        app:bulat_value="8" />
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
	implementation 'com.github.Merlinkoss:bulatmaterialcounterview:1.2'
}
```

License
----

MIT

**Free Software, Hell Yeah!**
