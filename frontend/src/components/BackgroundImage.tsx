import { IMAGES } from "@/constants/images.constants";

const BackgroundImage = () => {
    return (
        <figure className="w-1/2 h-full flex items-center justify-center">
            <img
                className="w-1/2"
                src={IMAGES.home.homepage}
                alt="Homepage illustration"
            />
        </figure>
    );
};

export { BackgroundImage };
