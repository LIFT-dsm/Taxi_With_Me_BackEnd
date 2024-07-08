package com.example.texiwithme.global.util;

import java.util.List;

public record PagingResult<T>(
        List<T> data,
        int dataOfNumber,
        boolean isLastPage
) {
}
