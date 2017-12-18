import org.springframework.context.support.ResourceBundleMessageSource
import ru.itpark.bean.Sample

beans {
    messageSource(ResourceBundleMessageSource) {
        basename = 'messages'
        defaultEncoding = 'utf-8'
    }

    sample(Sample) {
        messageSource = ref(messageSource)
    }
}