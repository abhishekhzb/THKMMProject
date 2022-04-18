import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()



	var body: some View {
		Text(greet)
		Text("My First Project!")
		Button("Button title") {
            print("Button tapped!")
        }
        Button("Submit") {}

        Button {
            print("Button pressed")
        } label: {
            Text("Press Me")
                .padding(20)
        }
        .contentShape(Rectangle())

        Text("The best laid plans")
            .padding()
            .background(Color.yellow)
            .foregroundColor(.white)
            .font(.title)

           Text("This is an extremely long text string that will never fit even the widest of phones without wrapping")
               .font(.largeTitle)
               .lineSpacing(50)
               .frame(width: 300)

	}



}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}