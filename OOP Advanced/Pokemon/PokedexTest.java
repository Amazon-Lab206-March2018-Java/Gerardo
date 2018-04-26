public class PokedexTest {

    public static void main (String[] args) {
        Pokedex pokedex = new Pokedex ();
        Pokemon bulbasaur = pokedex.createPokemon ("Bulbasaur", 110, "Plant/Poison");
        Pokemon squirtle = pokedex.createPokemon ("Squirtle", 100, "Water");
        Pokemon charmander = pokedex.createPokemon ("Charmander", 95, "Fire");
        
        System.out.println ( pokedex.pokemonInfo (bulbasaur) );
        System.out.println ( pokedex.pokemonInfo (squirtle) );
        System.out.println ( pokedex.pokemonInfo (charmander) );

        pokedex.attackPokemon (bulbasaur);

        System.out.println ( pokedex.pokemonInfo (bulbasaur) );

    }
}