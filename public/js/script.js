// Controls the speed of morphing.
const morphTime = .8;
const cooldownTime = 0.25;
const elts = {
	text1: document.getElementById("text1"),
	text2: document.getElementById("text2")
};

const texts = `
And you open the door and you step inside Where inside our hearts Now imagine your pain as a white ball of healing light That's right, your pain The pain itself is a white ball of healing light I don't think so This is your life, good to the last drop Doesn't get any better than This is your life and it's ending one minute at a time This isn't a seminar, this isn't a weekend retreat Where you are now you can't even imagine what the bottom will be like Only after disaster can we be resurrected It's only after you've lost everything that you're free to do anything Nothing is static, everything is evolving, everything is falling apart This is your life, this is your life, this is your life, this is your life Doesn't get any better than this And it and it's ending one-minute at a time You are not a beautiful and unique snowflake You are the same decaying organic matter as everything else We are all part of the same compost heap We are the all singing, all dancing, crap of the world You have to give up, you have to give up You have to realize that someday you will die Until you know that, you are useless I say let me never be complete I say may I never be content I say deliver me from Swedish furniture I say deliver me from clever arts I say deliver me from clear skin and perfect teeth I say you have to give up
`.split(" ");

let textIndex = texts.length - 1;
let time = new Date();
let morph = 0;
let cooldown = cooldownTime;

elts.text1.textContent = texts[textIndex % texts.length];
elts.text2.textContent = texts[(textIndex + 1) % texts.length];

function doMorph() {
	morph -= cooldown;
	cooldown = 0;
	
	let fraction = morph / morphTime;
	
	if (fraction > 1) {
		cooldown = cooldownTime;
		fraction = 1;
	}
	
	setMorph(fraction);
}

// A lot of the magic happens here, this is what applies the blur filter to the text.
function setMorph(fraction) {
	// fraction = Math.cos(fraction * Math.PI) / -2 + .5;
	
	elts.text2.style.filter = `blur(${Math.min(8 / fraction - 8, 100)}px)`;
	elts.text2.style.opacity = `${Math.pow(fraction, 0.4) * 100}%`;
	
	fraction = 1 - fraction;
	elts.text1.style.filter = `blur(${Math.min(8 / fraction - 8, 100)}px)`;
	elts.text1.style.opacity = `${Math.pow(fraction, 0.4) * 100}%`;
	
	elts.text1.textContent = texts[textIndex % texts.length];
	elts.text2.textContent = texts[(textIndex + 1) % texts.length];
}

function doCooldown() {
	morph = 0;
	
	elts.text2.style.filter = "";
	elts.text2.style.opacity = "100%";
	
	elts.text1.style.filter = "";
	elts.text1.style.opacity = "0%";
}

// Animation loop, which is called every frame.
function animate() {
	requestAnimationFrame(animate);
	
	let newTime = new Date();
	let shouldIncrementIndex = cooldown > 0;
	let dt = (newTime - time) / 1000;
	time = newTime;
	
	cooldown -= dt;
	
	if (cooldown <= 0) {
		if (shouldIncrementIndex) {
			textIndex++;
		}
		
		doMorph();
	} else {
		doCooldown();
	}
}

// Start the animation.
animate();