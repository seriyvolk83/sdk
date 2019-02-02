import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EncodingKtTest {

    @Test
    fun testByteToHexString() {
        assertThat((0x00.toByte()).toHexString()).isEqualTo("00")
    }

    @Test
    fun testByteToHexStringEC() {
        assertThat((0xEC.toByte()).toHexString()).isEqualTo("EC")
    }

    @Test
    fun testByteArrayToHexString() {
        val ba = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x54, 0x10, 0xEC.toByte(), 0x03, 0x61, 0x50, 0x00, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x26, 0x2F, 0x4A)
        assertThat(ba.toHexString()).isEqualTo("0000000000005410EC03615000090000000000262F4A")
    }

    @Test
    fun testStringToHexByteArray() {
        val ba = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x54, 0x10, 0xEC.toByte(), 0x03, 0x61, 0x50, 0x00, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x26, 0x2F, 0x4A)
        val str = "0000000000005410EC03615000090000000000262F4A"
        assertThat(str.toHexByteArray()).isEqualTo(ba)
    }

    @Test
    fun testStringToByteArray() {
        assertThat("00".toHexByteArray()).contains(0x00)
    }

    @Test
    fun testStringToTCByteArray() {
        val ba = byteArrayOf(0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x35, 0x34, 0x31, 0x30, 0x45, 0x43, 0x30, 0x33, 0x36, 0x31, 0x35, 0x30, 0x30, 0x30, 0x30, 0x39, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x32, 0x36, 0x32, 0x46, 0x34, 0x41)
        val str = "0000000000005410EC03615000090000000000262F4A"
        assertThat(str.toGWByteArray()).isEqualTo(ba)
    }

    @Test
    fun testStringToTCByteArraySmall() {
        assertThat("00".toGWByteArray()).contains(0x30, 0x30)
    }

    @Test
    fun testDecodeTC() {
        val batc = byteArrayOf(0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x35, 0x34, 0x31, 0x30, 0x45, 0x43, 0x30, 0x33, 0x36, 0x31, 0x35, 0x30, 0x30, 0x30, 0x30, 0x39, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x32, 0x36, 0x32, 0x46, 0x34, 0x41)
        val ba = byteArrayOf(0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x54, 0x10, 0xEC.toByte(), 0x03, 0x61, 0x50, 0x00, 0x09, 0x00, 0x00, 0x00, 0x00, 0x00, 0x26, 0x2F, 0x4A)
        assertThat(batc.decodeFromGW()).isEqualTo(ba)
    }
}
