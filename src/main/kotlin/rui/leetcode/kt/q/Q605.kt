package rui.leetcode.kt.q

class Q605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        // 方法1
        // 首先判断第一个位置是0，就放置一盆花
        // 然后迭代1 until n，
        // 判断当前位置flowerbed[i]与前一个位置的关系flowerbed[i - 1]
        //    如果前一个位置有花盆了（注意，这里只可能是我们刚刚放的，因为已经存在的花盆是符合规定的）
        //    且如果当前位置也有花盆：
        //       那么说明前面那个位置不应该放花盆
        //    如果前一个位置没有花盆，且当前位置也没有花盆：
        //       那么说明当前位置可以放一盆花
        // Passed 228ms 36.1mb
        var plants = 0
        if (flowerbed[0] == 0) {
            plants += 1
            flowerbed[0] = 1
        }
        for (i in 1 until flowerbed.size) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                plants += 1
                flowerbed[i] = 1
            }
            if (flowerbed[i - 1] == 1 && flowerbed[i] == 1) {
                plants -= 1
                flowerbed[i - 1] = 0
            }
        }
        return plants >= n
    }
}