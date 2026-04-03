package ch17

class P068_3 {
    fun isAnagram(s: String, t: String): Boolean = String(s.toCharArray().apply { sort() }) ==
        String(t.toCharArray().apply { sort() })
}
