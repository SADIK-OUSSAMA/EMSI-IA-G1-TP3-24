package ma.emsi.sadik.tp3sadik.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

/**
 * Interface utilisée par LangChain4j pour générer
 * le guide touristique via Gemini.
 */
public interface GuideTouristique {

    @SystemMessage("""
    Tu es un guide touristique.
    Pour le lieu donné (ville ou pays), indique :
    - Les deux principaux endroits à visiter.
    - Le prix moyen d'un repas dans la devise locale.
    Réponds en JSON exactement sous ce format :
    {
      "ville_ou_pays": "<nom>",
      "endroits_a_visiter": ["endroit 1", "endroit 2"],
      "prix_moyen_repas": "<prix> <devise>"
    }
    N'utilise pas Markdown.
    """)
    @UserMessage("Donne les informations touristiques sur {{it}}.")
    String informations(String villeOuPays);
}
