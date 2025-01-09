package org.skypro.skyshop.tools;

public final class ArrayTools {
    /**
     * Универсальный признак "не найдено".
     */
    public static final int NOT_FOUND = -1;

    /**
     * Получение первой от нуля свободной или занятой ячейки в хранилище.
     *
     * @return индекс свободной ячейки или {@link #NOT_FOUND}
     */
    public static <T> int getFirsIndex(T[] array, boolean free) {
        for (int i = 0; i < array.length; i++) {
            if (free && array[i] == null) {
                return i;
            }
            else if (!free && array[i] != null) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
