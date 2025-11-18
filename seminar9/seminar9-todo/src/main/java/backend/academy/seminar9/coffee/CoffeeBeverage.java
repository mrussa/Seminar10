package backend.academy.seminar9.coffee;

/**
 * Кофейный напиток определённого типа
 *
 * @param coffee количество кофе в миллилитрах в напитке (эспрессо)
 * @param water  количество дополнительной воды в миллилитрах в напитке (в основном для американо, который состоит из эспрессо и дополнительной воды)
 * @param milk   количество молока в миллилитрах в напитке
 */
public record CoffeeBeverage(
    int coffee,
    int water,
    int milk
) {
}
