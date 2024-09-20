package utility;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class NameBuilder {
	private final List<String> suffixes = Arrays.asList(
			"RAMBO", "ED", "DR", "CSAR", "THE", "TERMINATOR", "BSC",
			"CERTIFIED", "PROFESSIONAL", "DIP", "DIPED", "MSC",
			"MPH", "PHD", "MACA", "ASSOC", "PROF"
	);
	public String[] process(String name) {
		log.debug("Parsing input name [{}]", name);
		String f = null, l = null;
		String regex1 = "^[a-zA-Z,\'-]+$";
		String regex2 = "[\\.,;\'~\"()\\-]";
		String[] names = name.split("\\s+");
		boolean rev = false;
		for (String n : names) {
			if (n.matches(regex1)) {
				log.debug("Matching [{}] with acceptable characters [{}]", n, regex1);
				if (n.contains(",") && f == null) {
					log.debug("Check if [{}] is a last name", n);
					rev = true;
				}
				String cleaned = n.trim().replaceAll(regex2, "");
				log.debug("Clean [{}] results [{}]", n, cleaned);

				if (!suffixes.contains(cleaned.toUpperCase()) && cleaned.length() > 2) {
					log.debug("Check cleaned string [{}] against suffixes", cleaned);
					if (f == null) {
						f = convertName(cleaned);
					} else {
						l = (l == null) ? convertName(cleaned) : (l.equals("Del")) ? l + " " + convertName(cleaned) : (convertName(cleaned).trim().equals("Del")) ? convertName(cleaned) : l;
					}
				}
			}
		}
		String[] fullName = (f != null && l != null) ? (rev ? new String[]{l, f} : new String[]{f, l}) : null;
		if (fullName != null) {
			log.debug("Composing name [{}] with last name {}", Arrays.toString(fullName), rev ? "at the beginning" : "at the end");
			log.debug("Parsing input name [{}] results [{}]", name, Arrays.toString(fullName));
		}
		return fullName;
	}
	private String convertName(String input) {
		log.debug("Converting name [{}] to Proper Case", input);
		if ("APC".equals(input.trim()) || input.trim().startsWith("de")) return input.trim();
		if (input.length() == 1) return input.toUpperCase();

		StringBuilder result = new StringBuilder();
		Stream.of(input.split(" ")).forEach(part -> {
			result.append(part.length() > 1 ?
					Character.toUpperCase(part.charAt(0)) + part.substring(1).toLowerCase() :
					part.toUpperCase()).append(" ");
		});
		log.debug("Converting name [{}] results [{}]", input, result.toString().trim());
		return result.toString().trim();
	}
}


