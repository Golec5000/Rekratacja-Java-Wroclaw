# Przegląd projektu

Ten projekt to aplikacja Java, która dzieli koszyk produktów na grupy na podstawie ich metod dostawy. Metody dostawy dla każdego produktu są odczytywane z pliku konfiguracyjnego JSON.

## Kluczowe komponenty

### Klasa BasketSplitter

Klasa `BasketSplitter` to główny komponent tej aplikacji. Jest odpowiedzialna za podział koszyka produktów na grupy na podstawie ich metod dostawy.

#### Konstruktor

Klasa `BasketSplitter` ma konstruktor, który przyjmuje jako argument bezwzględną ścieżkę do pliku konfiguracyjnego JSON. Ten plik zawiera metody dostawy dla każdego produktu. Konstruktor inicjalizuje mapę konfiguracyjną, odczytując ten plik.

#### Metoda split

Metoda `split` to główna metoda klasy `BasketSplitter`. Przyjmuje jako argument listę produktów i dzieli je na grupy na podstawie ich metod dostawy. Metoda zwraca mapę, gdzie kluczami są metody dostawy, a wartościami listy produktów dla każdej metody dostawy. Jeśli lista produktów lub konfiguracja jest null, metoda wyrzuca wyjątek `IllegalArgumentException`.
#### Metoda getMostCommonDelivery

Metoda `getMostCommonDelivery` to metoda pomocnicza używana przez metodę `split`. Przyjmuje jako argument listę metod dostawy i zwraca najczęściej występującą metodę dostawy.

### Klasa JsonInPutter

Klasa `JsonInPutter` służy do odczytywania pliku konfiguracyjnego JSON. Jest używana przez klasę `BasketSplitter` do inicjalizacji mapy konfiguracyjnej.

## Zależności

Ten projekt to projekt Maven i wymaga następujących zależności:

- Java
- Maven

## Konfiguracja

Metody dostawy dla każdego produktu są konfigurowane w pliku JSON. Struktura tego pliku to mapa, gdzie kluczami są nazwy produktów, a wartościami listy metod dostawy. Przykładem tego pliku jest `config-test-1.json`. Produkty do podziału są odczytywane z pliku koszyka JSON. Struktura tego pliku to lista nazw produktów. Przykładem tego pliku jest `test-b-1.json`.
